import { Anexo } from "./anexo";
import { Responsavel } from "./responsavel";

export class Tarefa {

    id: number;
    nome: string;
    dataInicio: Date;
    dataConclusao: Date;
    status: boolean;
    responsavel: Responsavel;
    anexos: Anexo[] = [];

    constructor(){}
}
