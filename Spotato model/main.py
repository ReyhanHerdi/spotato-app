from fastapi import FastAPI, File, UploadFile
from fastapi.responses import JSONResponse
import shutil
import os
from feature_extraction import extract_features, svm_model
import numpy as np

app = FastAPI()

@app.post("/predict")
async def predict_image(file: UploadFile = File(...)):
    # Simpan file sementara
    temp_path = f"temp_{file.filename}"
    with open(temp_path, "wb") as buffer:
        shutil.copyfileobj(file.file, buffer)

    # Ekstrak fitur dan prediksi
    label_map = {
        0: "Early Blight",
        1: "Late Blight",
        2: "Healthy"
    }


    print("Classes:", svm_model.classes_)
    print("Label map:", label_map)

    try:
        features = extract_features(temp_path)
        prediction = svm_model.predict(features)
        # proba = svm_model.predict_proba(features)
        # pred_label = np.argmax(proba)

        print(prediction)
        # print(proba)
        os.remove(temp_path)  # hapus setelah dipakai
        return JSONResponse(content={
            "prediction": int(prediction),
            # "class_name": label_map[pred_label],
            
        })
    except Exception as e:
        return JSONResponse(content={"error": str(e)}, status_code=500)

print("Success")