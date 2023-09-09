import cv2
import os


class NegativeImage:
    def __init__(self) -> None:
        self.negative_images = {}  # Rename the instance variable to avoid conflicts

    def create_negative_image(self, image_path):
        # Load the image
        image_name = os.path.basename(image_path)
        print(image_name)
        save_path = "static/output_images/negative/"  # Replace with the path to save the negative image
        saved_image_path = os.path.join(save_path, image_name)
        original_image = cv2.imread(image_path)

        if not os.path.exists(save_path):
            os.makedirs(save_path)

        # Calculate the maximum intensity value (usually 255 for 8-bit images)
        intensity_max = 255

        # Create a negative image by subtracting each pixel value from the intensity_max
        negative_image = intensity_max - original_image

        # Save the negative image to a file if needed
        cv2.imwrite(saved_image_path, negative_image)

        self.negative_images[
            image_name
        ] = saved_image_path  # Store the result in the instance variable

        return {"original_image": image_path, "negative_image": saved_image_path}
