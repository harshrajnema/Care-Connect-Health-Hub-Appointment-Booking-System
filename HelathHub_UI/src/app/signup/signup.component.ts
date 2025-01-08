import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'], // Add CSS for custom styling
})
export class SignupComponent {
  constructor(private http: HttpClient, private router: Router) {}

  onSubmit(signupForm: any) {
    const formData = signupForm.value;
    console.log('Form Data:', formData);

    // Call API to send the data to the backend
    this.http.post('http://your-backend-api-url/register', formData).subscribe({
      next: (response) => {
        console.log('Registration successful:', response);
        alert('Registration successful! Redirecting to login...');
        
        // Redirect to Login page
        this.router.navigate(['/login']);
      },
      error: (error) => {
        console.error('Error during registration:', error);
        alert('Registration failed. Please try again.');
      },
    });
  }

  onCancel() {
    console.log('User canceled the registration.');
    // Redirect to login page or perform any other action
    this.router.navigate(['/login']);
  }
}
