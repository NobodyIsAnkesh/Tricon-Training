import React from 'react';

export class Albums extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            filter: ''
        };
        this.filterUpdate = this.filterUpdate.bind(this);
    }

    filterUpdate = (e) => {
        let value = e.target.value;
        this.setState({
            filter: value
        })
    }

    render() {
        let albums = this.props.albums;
        return (
            <div className="albums">
                Filter By ID:
                <input type="number" onChange={this.filterUpdate}></input>
                {
                    albums.map((album) => {
                        if (album.id == this.state.filter || this.state.filter == '') {
                            return (
                                <div className="album" key={album.id}>
                                    <ul>
                                        <li>{album.id}</li>
                                        <li>{album.title}</li>
                                    </ul>
                                </div>
                            )
                        }
                        else
                            return (<div></div>)
                    })
                }
            </div>
        )
    }

}

export default Albums;
