import './App.css';
import {createMuiTheme, ThemeProvider} from '@material-ui/core/styles';
import ClippedDrawer from "./components/Navbar";
import {BrowserRouter as Router} from "react-router-dom";

const theme = createMuiTheme({
    palette: {
        palette: {
            type: 'dark',
        },
        primary: {
            // Purple and green play nicely together.
            main: "#14b9dd",
        },
        secondary: {
            // This is green.A700 as hex.
            main: '#dd3914',
        },
    },
});

export default function ButtonAppBar() {

    return (
        <ThemeProvider theme={theme}>

            <Router>
                <ClippedDrawer classes/>
            </Router>
        </ThemeProvider>

    );
}


