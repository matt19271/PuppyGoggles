import React from 'react'

export default props => 
  props.images.map((image, i) =>
    <div key={i} className='fadein'>
      <div 
        onClick={() => props.removeImage(image.public_id)} 
        className='delete'
      >
        X
      </div>
      <img src={image.secure_url} alt='' />
    </div>
  )