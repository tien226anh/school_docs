# Run: python api.py
import pickle
import numpy as np
from flask import Flask, request, jsonify, json

app = Flask(__name__)

# --- The file name of the saved model ---
filename = "diabetes.sav"

# --- Load the saved model ---
loaded_model = pickle.load(open(filename, "rb"))


@app.route("/")
def index():
    return "Hello, World!"


@app.route("/diabetes/v1/predict", methods=["POST"])
def predict():
    # ---get the features to predict---
    features = request.json

    # ---create the features list for prediction---
    features_list = [features["Glucose"], features["BMI"], features["Age"]]

    # ---get the prediction class---
    prediction = loaded_model.predict([features_list])

    # ---get the prediction probabilities---
    confidence = loaded_model.predict_proba([features_list])

    # ---formulate the response to return to client---
    response = {}
    response["prediction"] = int(prediction[0])
    response["confidence"] = str(round(np.amax(confidence[0]) * 100, 2))

    return jsonify(response)


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
