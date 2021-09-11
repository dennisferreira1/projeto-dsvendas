import { Vendedor } from './vendedor';

export type Venda = {
        id: number,
        visitado: number,
        vendaComSucesso: number,
        valorVendido: number,
        data: string,
        vendedorDTO: Vendedor
}

export type VendaPage = {
    content?: Venda[],
    last: boolean,
    totalPages: number,
    totalElements?: number,
    first: boolean,
    size?: number,
    number: number,
    numberOfElements?: number,
    empty?: boolean
}

export type TotalVendasPorVendedor = {
    nomeVendedor: string,
    somaValorTotal: number
}

export type VendasSucessoPorVendedor = {
    nomeVendedor: string,
    totalVisitado: number,
    totalVendasComSucesso: number
}