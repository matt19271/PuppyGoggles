import React from 'react';
import { Form, FormGroup, Label, Input, FormText, Col } from 'reactstrap';

export default class Upload extends React.Component {
  render() {
    return (
      <Form>
        <FormGroup row>
        <Label for="exampleFile" sm={2}>Upload Puppy Pic</Label>
        <Col sm={10}>
          <Input type="file" name="file" id="exampleFile" />
          <FormText color="muted">
            Upload an image of the lost puppy.
          </FormText>
        </Col>
        </FormGroup>
      </Form>
    )
  }
}
