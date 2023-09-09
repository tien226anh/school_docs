import shutil
import uvicorn
from fastapi import FastAPI, File, UploadFile
from fastapi.staticfiles import StaticFiles
from negative import NegativeImage
from thresholding import ThresholdImage
from logarithm import LogarithmImage

app = FastAPI()
negative = NegativeImage()
threshold = ThresholdImage()
logarithm = LogarithmImage()

app.mount("/static", StaticFiles(directory="static"), name="static")


def process_image(file, image_processor):
    file_location = f"static/images/{file.filename}"
    with open(file_location, "wb") as image:
        shutil.copyfileobj(file.file, image)
    return image_processor(file_location)


@app.get("/")
async def index():
    return {"message": "Hello World"}


@app.post("/negative")
async def negative_image(file: UploadFile = File(...)):
    return process_image(file, negative.create_negative_image)


@app.post("/thresholding")
async def threshold_image(file: UploadFile = File(...)):
    return process_image(file, threshold.create_threshold_image)


@app.post("/logarithm")
async def logarithm_image(file: UploadFile = File(...)):
    return process_image(file, logarithm.create_log_image)


@app.post("/inverse_logarithm")
async def inverse_logarithm_image(file: UploadFile = File(...)):
    return process_image(file, logarithm.create_inverse_log_image)


if __name__ == "__main__":
    uvicorn.run("main:app", host="0.0.0.0", port=8000, reload=True)
