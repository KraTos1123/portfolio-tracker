import React from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import NetworthCard from "./cards/Networth";
import ProfitCard from "./cards/Profit";
import TotalInvestmentCard from "./cards/Invested";

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
    paper: {
        padding: theme.spacing(2),
        textAlign: 'center',
        color: theme.palette.text.secondary,
    },
}));

export default function AutoGrid() {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <Grid container spacing={3}>
                <Grid item xs>
                    <TotalInvestmentCard/>
                </Grid>
                <Grid item xs>
                    <NetworthCard/>
                </Grid>
                <Grid item xs>
                    <ProfitCard/>
                </Grid>
            </Grid>
        </div>
    );
}