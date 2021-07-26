import { Tarefa } from "./tarefa";

export class Responsavel {

    id: number;
    nome: string;
    dataNascimento: Date;
    email: string;
    tarefas: Tarefa[] = [];

    constructor(){}
}
