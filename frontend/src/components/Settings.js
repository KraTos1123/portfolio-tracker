import {makeStyles} from "@material-ui/core/styles";
import CssBaseline from "@material-ui/core/CssBaseline";
import React from "react";

const useStyles = makeStyles((theme) => ({
    root: {
        display: 'flex',
    },
    content: {
        flexGrow: 1,
        padding: theme.spacing(3),
    },
}));


export default function Settings() {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <CssBaseline />
            <h1>Hello This is your Settings Page</h1>
        </div>
    );

}