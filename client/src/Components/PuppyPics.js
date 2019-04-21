import React from 'react';
import Puppy from '../components/Puppy';
import { CardColumns, Row } from 'reactstrap';

const Restaurants = ({ puppies }) => {
  return (
    <Row className="justify-content-sm-center">
      <CardColumns>
        {puppies.map((puppy) => (
          <Puppy key={puppy.id} restaurant={puppy} />
        ))}
      </CardColumns>
    </Row>
  )
}

export default Restaurants