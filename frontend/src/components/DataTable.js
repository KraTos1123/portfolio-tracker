import React from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TablePagination from '@material-ui/core/TablePagination';
import TableRow from '@material-ui/core/TableRow';

const columns = [
    {id: 'name', label: 'Name', minWidth: 170},
    // {id: 'code', label: 'ISO\u00a0Code', minWidth: 100},
    {
        id: 'absolutePnl',
        label: 'Absolute Profit',
        minWidth: 170,
        align: 'right',
        format: (value) => value.toLocaleString('en-US'),
    },
    {
        id: 'percentPnl',
        label: 'percentage Profit',
        minWidth: 170,
        align: 'right',
        format: (value) => value.toLocaleString('en-US'),
    },
    {
        id: 'totalInvestments',
        label: 'Total Investment',
        minWidth: 170,
        align: 'right',
        format: (value) => value.toFixed(2),
    },
    {
        id: 'assetValue',
        label: 'Asset Value',
        minWidth: 170,
        align: 'right',
        format: (value) => value.toFixed(2),
    },
];


function fetchAssetData(name, absolutePnl, percentPnl, totalInvestments, assetValue) {

    return {name, absolutePnl, percentPnl, totalInvestments, assetValue};
}

const assetRows = [
    fetchAssetData('India', 'IN', 1324171354, 3287263, 300000),
    fetchAssetData('China', 'CN', 1403500365, 9596961, 300000),
    fetchAssetData('Italy', 'IT', 60483973, 301340, 300000),
    fetchAssetData('United States', 'US', 327167434, 9833520, 300000),
    fetchAssetData('Canada', 'CA', 37602103, 9984670, 300000),
    fetchAssetData('Australia', 'AU', 25475400, 7692024, 300000),
    fetchAssetData('Germany', 'DE', 83019200, 357578, 300000),
    fetchAssetData('Ireland', 'IE', 4857000, 70273, 300000),
    fetchAssetData('Mexico', 'MX', 126577691, 1972550, 300000),
    fetchAssetData('Japan', 'JP', 126317000, 377973, 300000),
    fetchAssetData('France', 'FR', 67022000, 640679, 300000),
    fetchAssetData('United Kingdom', 'GB', 67545757, 242495, 300000),
    fetchAssetData('Russia', 'RU', 146793744, 17098246, 300000),
    fetchAssetData('Nigeria', 'NG', 200962417, 923768, 300000),
    fetchAssetData('Brazil', 'BR', 210147125, 8515767, 300000),
];


const useStyles = makeStyles({
    root: {
        width: '100%',
    },
    container: {
        maxHeight: 440,
    },
});

export default function StickyHeadTable() {
    const classes = useStyles();
    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(10);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(+event.target.value);
        setPage(0);
    };

    return (
        <Paper className={classes.root}>
            <TableContainer className={classes.container}>
                <Table stickyHeader aria-label="sticky table">
                    <TableHead>
                        <TableRow>
                            {columns.map((column) => (
                                <TableCell
                                    key={column.id}
                                    align={column.align}
                                    style={{minWidth: column.minWidth}}
                                >
                                    {column.label}
                                </TableCell>
                            ))}
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {assetRows.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row) => {
                            return (
                                <TableRow hover role="checkbox" tabIndex={-1} key={row.code}>
                                    {columns.map((column) => {
                                        const value = row[column.id];
                                        return (
                                            <TableCell key={column.id} align={column.align}>
                                                {column.format && typeof value === 'number' ? column.format(value) : value}
                                            </TableCell>
                                        );
                                    })}
                                </TableRow>
                            );
                        })}
                    </TableBody>
                </Table>
            </TableContainer>
            <TablePagination
                rowsPerPageOptions={[10, 25, 100]}
                component="div"
                count={assetRows.length}
                rowsPerPage={rowsPerPage}
                page={page}
                onChangePage={handleChangePage}
                onChangeRowsPerPage={handleChangeRowsPerPage}
            />
        </Paper>
    );
}