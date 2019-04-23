import React from 'react';
import { Jumbotron, Button, Media } from 'reactstrap';
import PuppyLogo from '../images/puppygoggles.jpg'

const Home = () => {
  return (
    <div>
      <Jumbotron>
        <Media style={{ width: "100%" }} src={PuppyLogo}></Media>
        <h1 className="display-3">Welcome to PuppyGoggles!</h1>
        <hr className="my-2" />
        <p>Whether you have lost your puppy or found a lost puppy we can help you connect the dogs!</p>
        <p className="lead">
          <Button color="primary">Learn More</Button>
        </p>
      </Jumbotron>
    </div>
  );
};

export default Home;