'use strict';

// tag::vars[]
const React = require('react');
const client = require('./client');
// end::vars[]

// tag::app[]
class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {journalEntries: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/journalEntries'}).done(response => {
            this.setState({journalEntries: response.entity._embedded.journalEntries});
        });
    }

    render() {
        return (
            <JournalEntries journalEntries={this.state.journalEntries}/>
        )
    }
}
// end::app[]

// tag::journal-list[]
class JournalEntries extends React.Component {
    render() {
        var journalEntries = this.props.journalEntries.map(journal =>
            <Journal key={journal._links.self.href} journal={journal}/>
        );
        return (
            <table>
                <tr>
                    <th>Title</th>
                    <th>Created Date</th>
                    <th>Summary</th>
                </tr>
                {journalEntries}
            </table>
        )
    }
}
// end::journal-list[]

// tag::journal[]
class Journal extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.journal.title}</td>
                <td>{this.props.journal.createdAsShort}</td>
                <td>{this.props.journal.summary}</td>
            </tr>
        )
    }
}
// end::journal[]

// tag::render[]
React.render(
    <App />,
    document.getElementById('react')
);
// end::render[]

