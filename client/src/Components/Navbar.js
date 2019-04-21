import React from 'react';
import {
  Media,
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem } from 'reactstrap';
import PuppyIcon from '../images/puppyg.jpg'

export default class Example extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false
    };
  }
  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }
  render() {
    return (
      <div>
        <Navbar color="dark" expand="md">
          <NavbarBrand href="/"><Media src={PuppyIcon} style={{ height: 50}}/></NavbarBrand>
          <NavbarToggler onClick={this.toggle} />
          <Collapse isOpen={this.state.isOpen} navbar>
            <Nav className="ml-auto" navbar>
              <NavItem>
                <NavLink className="text-warning" href="/Puppypics">View Puppy Pics</NavLink>
              </NavItem>
              <NavItem>
                <NavLink className="text-warning" href="http://www.laanimalservices.com/">LA Animal Services</NavLink>
              </NavItem>
              <UncontrolledDropdown nav inNavbar>
                <DropdownToggle className="text-warning"  nav caret>
                  Lost/Found
                </DropdownToggle>
                <DropdownMenu right>
                  <DropdownItem href="/LostMyDog">
                    I lost my puppy
                  </DropdownItem>
                  <DropdownItem href="/FoundLostDog">
                    I found a lost puppy
                  </DropdownItem>
                </DropdownMenu>
              </UncontrolledDropdown>
            </Nav>
          </Collapse>
        </Navbar>
      </div>
    );
  }
}