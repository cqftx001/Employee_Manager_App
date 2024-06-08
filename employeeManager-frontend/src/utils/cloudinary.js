import { Cloudinary } from 'cloudinary-core';

const cloudinary = new Cloudinary({ 
  cloud_name: 'YOUR_CLOUD_NAME', 
  api_key: 'YOUR_API_KEY', 
  api_secret: 'YOUR_API_SECRET'
});

export default cloudinary;
