import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom"
import About from './about/About';
import Albums from './albums/Albums';
import Homepage from './homepage/Homepage';
import axios from 'axios';


export class App extends React.Component {

  state = {
    albums: []
  };

  componentDidMount() {
    axios.get("https://jsonplaceholder.typicode.com/albums")
      .then((response) => {
        this.setState({
          albums: response.data
        })
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  render() {
    return (
      <Router>
        <div>
          <nav>
            <ul>
              <li>
                <Link to="/">Homepage</Link>
              </li>
              <li>
                <Link to="/about/">About</Link>
              </li>
              <li>
                <Link to="/albums/">Albums</Link>
              </li>
            </ul>
          </nav>

          <Route path="/" exact component={Homepage} />
          <Route path="/about/" component={About} />
          <Route path="/albums/" render={() => <Albums albums={this.state.albums}></Albums>} />
        </div>
      </Router>
    );
  }
}

export default App;
