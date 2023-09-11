import shutil
import uvicorn
from fastapi import FastAPI, File, UploadFile
from fastapi.staticfiles import StaticFiles
from logarithm import LogarithmImage
from negative import NegativeImage
from thresholding import ThresholdImage

app = FastAPI()
image_processors = {
    "negative": NegativeImage(),
    "thresholding": ThresholdImage(),
    "logarithm": LogarithmImage(),
    "inverse_logarithm": LogarithmImage(),
}

app.mount("/static", StaticFiles(directory="static"), name="static")


def process_image(file, image_processor):
    file_location = f"static/images/{file.filename}"
    with open(file_location, "wb") as image:
        shutil.copyfileobj(file.file, image)
    return image_processor(file_location)


@app.get("/")
async def index():
    return {"message": "Hello World"}


@app.post("/process_image")
async def process_image_endpoint(processor_name: str, file: UploadFile = File(...)):
    if processor_name in image_processors:
        if processor_name != "inverse_logarithm":
            return process_image(file, image_processors[processor_name].process_image)
        else:
            return process_image(file, image_processors[processor_name].process__image)
    else:
        return {"error": "Invalid image processor name"}


if __name__ == "__main__":
    uvicorn.run("main:app", host="0.0.0.0", port=8000, reload=True)
