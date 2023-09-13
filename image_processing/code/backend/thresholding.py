# thresholding.py
import cv2
import numpy as np
import os


class ThresholdImage:
    def __init__(self) -> None:
        self.threshold_images = {}

    def process_image(self, image_path):
        image_name = os.path.basename(image_path)
        save_path = "static/output_images/threshold"
        saved_image_path = os.path.join(save_path, image_name)

        if not os.path.exists(save_path):
            os.makedirs(save_path)

        image1 = cv2.imread(image_path)
        img = cv2.cvtColor(image1, cv2.COLOR_BGR2GRAY)

        ret, thresh1 = cv2.threshold(img, 120, 255, cv2.THRESH_BINARY)
        ret, thresh2 = cv2.threshold(img, 120, 255, cv2.THRESH_BINARY_INV)
        ret, thresh3 = cv2.threshold(img, 120, 255, cv2.THRESH_TRUNC)
        ret, thresh4 = cv2.threshold(img, 120, 255, cv2.THRESH_TOZERO)
        ret, thresh5 = cv2.threshold(img, 120, 255, cv2.THRESH_TOZERO_INV)

        cv2.imwrite(f"{saved_image_path}_binary_threshold.jpg", thresh1)
        cv2.imwrite(f"{saved_image_path}_binary_threshold_inverted.jpg", thresh2)
        cv2.imwrite(f"{saved_image_path}_truncated_threshold.jpg", thresh3)
        cv2.imwrite(f"{saved_image_path}_set_to_0.jpg", thresh4)
        cv2.imwrite(f"{saved_image_path}_set_to_0_inverted.jpg", thresh5)

        return {
            "original_image": image_path,
            "processed_image": f"{save_path}/{image_name}_binary_threshold.jpg",
            # "threshold_images": {
            #     "binary_threshold": f"{save_path}/{image_name}_binary_threshold.jpg",
            #     "binary_threshold_inverted": f"{save_path}/{image_name}_binary_threshold_inverted.jpg",
            #     "truncated_threshold": f"{save_path}/{image_name}_truncated_threshold.jpg",
            #     "set_to_0": f"{save_path}/{image_name}_set_to_0.jpg",
            #     "set_to_0_inverted": f"{save_path}/{image_name}_set_to_0_inverted.jpg",
            # },
        }
