import pickle
import numpy as np
from tensorflow.keras.models import Model
from tensorflow.keras.applications import MobileNet
from tensorflow.keras.applications.mobilenet import preprocess_input
from tensorflow.keras.preprocessing import image

svm_model_pickle = "mobilenet_svm_repisi.pkl"
with open(svm_model_pickle, "rb") as sm:
    svm_model = pickle.load(sm)

mobilenet_pickle = "mobilenet_model.pkl"
with open(mobilenet_pickle, "rb") as mnm:
    mobilenet_model = pickle.load(mnm)

scaler_pickle = "min_max_scaler.pkl"
with open(scaler_pickle, "rb") as scl:
    min_max_scaler = pickle.load(scl)

mobilenet_model.summary()
mobilenet = Model(inputs=mobilenet_model.input,outputs=mobilenet_model.get_layer("dense").output)
def extract_features(img_path):
    img = image.load_img(img_path, target_size=(224, 224))  # ukuran default MobileNet
    img_array = image.img_to_array(img)
    img_array = np.expand_dims(img_array, axis=0)
    img_array = img_array / 255.0
    features = mobilenet.predict(img_array)
    features = features.reshape(1, -1)
    features_scaled = min_max_scaler.transform(features)
    return features_scaled