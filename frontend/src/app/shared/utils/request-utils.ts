import { HttpParams } from "@angular/common/http";
import { Table } from "primeng";

export class RequestUtils {

    static getRequestParamsTable = (dataTable: Table): HttpParams => {
        let params: HttpParams = new HttpParams();
        if (params == null) {
            params = params.append('size', '10');
            return params;
        }

        console.log(dataTable);
        params = params.append('page', Math.round(dataTable.first / dataTable.rows).toString());
        params = params.append('size', dataTable.rows == null ? '10' : dataTable.rows.toString());

        const direcao = dataTable.sortOrder === 1 ? 'ASC' : 'DESC';
        params = params.append('sort', dataTable.sortField == null ? '' : dataTable.sortField + ', ' + direcao);

        return params;
    }

    static getRequestParams = (objeto: Object): HttpParams => {

        let params: HttpParams = new HttpParams();

        if (!!objeto) {
            Object.keys(objeto).forEach(param => {
                params = params.append(param, objeto[param]);
            });
        }
        return params;
    }
}
