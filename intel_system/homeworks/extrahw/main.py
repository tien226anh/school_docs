import uvicorn
import pickle
import numpy as np
from pydantic import BaseModel
from fastapi import FastAPI


class Features(BaseModel):
    score_1: float
    score_2: float
    score_3: float


app = FastAPI()

filename1 = "./scores.sav"
filename2 = "./linear.sav"

loaded_model1 = pickle.load(open(filename1, "rb"))
loaded_model2 = pickle.load(open(filename2, "rb"))


@app.get("/")
def index():
    return "Hello world!"


@app.post("/score/v1/predict/knregression")
def knregression(features: Features):
    features_arr = np.array([features.score_1, features.score_2, features.score_3])

    prediction = loaded_model1.predict([features_arr])

    response = {"prediction": prediction[0]}

    return response


@app.post("/score/v1/predict/linear")
def linear(features: Features):
    features_arr = np.array([features.score_1, features.score_2, features.score_3])

    prediction = loaded_model2.predict([features_arr])

    response = {"prediction": prediction[0]}

    return response


if __name__ == "__main__":
    uvicorn.run(app, host="localhost", port=8000, reload=True)
