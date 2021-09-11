import axios from "axios";
import Paginacao from "components/Paginacao";
import { useEffect } from "react";
import { useState } from "react";
import { VendaPage } from "types/venda";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {

    const [pageAtiva, setPageAtiva] = useState(0);
    const [page, setPage] = useState<VendaPage>({
        last: true,
        totalElements: 0,
        first: true,
        number: 0,
        totalPages: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/vendas?page=${pageAtiva}&size=10&sort=data,desc`)
            .then(response => {
                setPage(response.data);
            })
    }, [pageAtiva])

    const changePage = (index: number) => setPageAtiva(index);
    

    return (
        <>
             <Paginacao page={page} onPageChange={changePage} />
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th>Vendedor</th>
                            <th>Clientes visitados</th>
                            <th>Negócios fechados</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>

                        {page.content?.map(item => (
                            <tr key={item.id}>
                                <td>{formatLocalDate(item.data,"dd/MM/yyyy")}</td>
                                <td>{item.vendedorDTO.nome}</td>
                                <td>{item.visitado}</td>
                                <td>{item.vendaComSucesso}</td>
                                <td>{item.valorVendido.toFixed(2)}</td>
                            </tr>
                        ))}

                    </tbody>
                </table>
            </div>

        </>
    );
}

export default DataTable;
