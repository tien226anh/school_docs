import cv2
import numpy as np
import os


class LogarithmImage:
    def __init__(self):
        self.log_images = {}
        self.inverse_log_images = {}

    def _process_image(self, image_path, transformation_func, output_dir):
        image_name = os.path.basename(image_path)
        save_path = os.path.join("static/output_images", output_dir)
        saved_image_path = os.path.join(save_path, image_name)
        original_image = cv2.imread(image_path)

        if not os.path.exists(save_path):
            os.makedirs(save_path)

        epsilon = 1e-5
        original_image_with_epsilon = original_image + epsilon

        max_input_pixel_value = np.max(original_image_with_epsilon)

        c = 255 / np.log(1 + max_input_pixel_value)

        transformed_image = c * transformation_func(original_image_with_epsilon)

        transformed_image = np.clip(transformed_image, 0, 255)
        transformed_image = np.uint8(transformed_image)

        cv2.imwrite(saved_image_path, transformed_image)

        return {"original_image": image_path, output_dir: saved_image_path}

    def process_image(self, image_path):
        def log_transformation(image):
            return np.log(1 + image)

        return self._process_image(image_path, log_transformation, "logarithm")

    def create_inverse_log_image(self, image_path):
        def inverse_log_transformation(image):
            return (np.exp(image) - 1) / (np.exp(1) - 1)

        return self._process_image(
            image_path, inverse_log_transformation, "inverse_logarithm"
        )
