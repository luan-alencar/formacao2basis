export class Page<T> {

    content: T[] = [];
    primeiro: boolean;
    ultimo: boolean;
    totalElementos: number;
    totalPaginas: number;
    tamanho: number;
    numero: number;
    numeroDeElementos: number;
    sort: string;

    constructor() { }
}
