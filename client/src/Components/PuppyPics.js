import React from 'react';
import Puppies from '../images/puppies.jpg';
import Puppy from '../images/puppy.jpg';
import Puppy2 from '../images/puppy2.jpg';
import { Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, CardColumns, Row } from 'reactstrap';

const PuppyPics = () => {
  return (
    <Row className="justify-content-sm-center">
      <CardColumns>
      <Card style={{backgroundColor: 'yellow', margin: '.5rem' }}>
            <CardImg top width="50%" src={Puppy} alt="Card image cap" />
            <CardBody>
                <CardTitle><h5>Found: in Long Beach, CA</h5></CardTitle>
                <CardSubtitle>Breeds:</CardSubtitle>
                <CardText>
                    Breed 1: 60%<br/>
                    Breed 2: 40%<br/>
                    Breed 3: 50%
                </CardText>
            </CardBody><br/>
        </Card>
        <Card style={{backgroundColor: 'yellow', margin: '.5rem' }}>
            <CardImg top width="50%" src={Puppy2} alt="Card image cap" />
            <CardBody>
                <CardTitle><h5>Lost: in Long Beach, CA</h5></CardTitle>
                <CardSubtitle>Breeds:</CardSubtitle>
                <CardText>
                    Breed 1: 60%<br/>
                    Breed 2: 40%<br/>
                    Breed 3: 50%
                </CardText>
            </CardBody><br/>
        </Card>
        <Card style={{backgroundColor: 'yellow', margin: '.5rem' }}>
            <CardImg top width="50%" src={Puppies} alt="Card image cap" />
            <CardBody>
                <CardTitle><h5>Found: in Long Beach, CA</h5></CardTitle>
                <CardSubtitle>Breeds:</CardSubtitle>
                <CardText>
                    Breed 1: 60%<br/>
                    Breed 2: 40%<br/>
                    Breed 3: 50%
                </CardText>
            </CardBody><br/>
        </Card>
      </CardColumns>
    </Row>
  )
}

export default PuppyPics