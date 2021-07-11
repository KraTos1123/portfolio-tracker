import CssBaseline from "@material-ui/core/CssBaseline";
import React from "react";
import StickyHeadTable from "./DataTable";
import Typography from "@material-ui/core/Typography";
import {Button, Divider, Toolbar} from "@material-ui/core";
import AutoGrid from "./CardGrid";


export default function Portfolio() {

    return (
        <div>
            <CssBaseline/>
            <Typography variant="h3" noWrap>
                Portfolio
                <Button variant="contained" color="primary" style={{float: "right"}}>
                    Add Asset
                </Button>
            </Typography>
            <Toolbar/>
            <AutoGrid/>
            <Toolbar/>
            <Divider light/>
            <Toolbar/>
            <StickyHeadTable/>
        </div>
    );

}