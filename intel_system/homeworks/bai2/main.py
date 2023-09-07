import pickle
import numpy as np
import uvicorn
from fastapi import FastAPI
from pydantic import BaseModel

class Features(BaseModel):
  Glucose: float
  BMI: float
  Age: float

app = FastAPI()

# --- The file name of the saved model ---
filename = 'diabetes.sav'

# --- Load the saved model ---
loaded_model = pickle.load(open(filename, 'rb'))

@app.get('/')
def index():
  return 'Hello, World!'

@app.post('/diabetes/v1/predict')
def predict(features: Features):
  features_array = np.array([features.Glucose, features.BMI, features.Age])
  
  prediction = loaded_model.predict([features_array])
  confidence = loaded_model.predict_proba([features_array])
  if(prediction[0] == 1):
    prediction = "Diabetic"
  else:
    prediction = "Not Diabetic"
  
  response = {
    "prediction": prediction,
    "confidence": str(round(np.amax(confidence[0]) * 100 ,2))
  }
  
  return response

if __name__ == '__main__':
  uvicorn.run(app, host="localhost", port=5000, reload=True)