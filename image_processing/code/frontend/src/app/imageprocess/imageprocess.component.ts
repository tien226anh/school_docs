import { ImageProcessingResponse } from './../interface/image-processing-response';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Processor } from '@app/interface/processor';
import { environment } from 'environments/environment.development';

@Component({
  selector: 'app-imageprocess',
  templateUrl: './imageprocess.component.html',
  styleUrls: ['./imageprocess.component.scss']
})
export class ImageprocessComponent implements OnInit {
  BASE_URL = `${environment.apiUrl}`;
  imageForm!: FormGroup;
  originalImageURL = '';
  negativeImageURL = '';
  processorNames: Processor[] = [
    { name: 'negative', viewValue: 'Negative' },
    { name: 'thresholding', viewValue: 'Thresholding' },
    { name: 'logarithm', viewValue: 'Logarithm' },
    { name: 'inverse_logarithm', viewValue: 'Inverse Logarithm' },
  ]

  constructor(private formBuilder: FormBuilder, private http: HttpClient) {}

  ngOnInit(): void {
    this.imageForm = this.formBuilder.group({
      processor_name: ['negative'], // Mặc định chọn processor "negative", bạn có thể thay đổi tùy ý
      imageFile: [''],
    });
  }

  onFileChange(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    if (inputElement.files && inputElement.files.length > 0) {
      const file = inputElement.files[0];
      this.imageForm.patchValue({ imageFile: file });
    }
  }

  onSubmit(): void {
    const formData = new FormData();
    formData.append('file', this.imageForm.get('imageFile')?.value);

    this.http.post<ImageProcessingResponse>(
      `${this.BASE_URL}/process_image/?processor_name=${this.imageForm.get('processor_name')?.value}`,
      formData
      ).subscribe(
      (response: ImageProcessingResponse) => {
        console.log('Image uploaded and processed:', response.processed_image);
        this.originalImageURL = `${this.BASE_URL}/${response.original_image}`;
        this.negativeImageURL = `${this.BASE_URL}/${response.processed_image}`;
        // Xử lý kết quả từ API ở đây (nếu cần)
      },
      (error) => {
        console.error('Error uploading image:', error);
        // Xử lý lỗi nếu cần
      }
    );
  }
}
