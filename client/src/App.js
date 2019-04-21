import React, { Component } from 'react'
import Spinner from './Components/Spinner'
import Images from './Components/Images'
import Navbar from './Components/Navbar'
import  { BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Home from './Components/HomePage'
import Upload from './Components/Upload'
import PuppyPics from './Components/PuppyPics'
import {Button} from 'reactstrap'
// import { API_URL } from './config'
import './App.css'

export default class App extends Component {
  
  state = {
    uploading: false,
    images: []
  }

  onChange = e => {
    // const files = Array.from(e.target.files)
    // this.setState({ uploading: true })

    // const formData = new FormData()

    // files.forEach((file, i) => {
    //   formData.append(i, file)
    // })

    // fetch(`${API_URL}/image-upload`, {
    //   method: 'POST',
    //   body: formData
    // })
    // .then(res => res.json())
    // .then(images => {
    //   this.setState({ 
    //     uploading: false,
    //     images
    //   })
    // })
  }

  removeImage = id => {
    this.setState({
      images: this.state.images.filter(image => image.public_id !== id)
    })
  }
  
  render() {
    const { uploading, images } = this.state

    const content = () => {
      switch(true) {
        case uploading:
          return <Spinner />
        case images.length > 0:
          return <Images images={images} removeImage={this.removeImage} />
        default:
          return <Button onChange={this.onChange} />
      }
    }

    return (
      <div>
        <Navbar />
        <Router>
          <Switch>
            <Route exact path="/" component={Home}/>
            <Route exact path="/LostMyDog" component={Upload}/>
            <Route exact path="/FoundLostDog" component={Upload}/>
            <Route exact path="/PuppyPics" component={PuppyPics}/>
          </Switch>
        </Router>
      </div>
    )
  }
}
