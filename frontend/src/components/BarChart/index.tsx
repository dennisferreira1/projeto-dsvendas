import axios from 'axios';
import { useEffect } from 'react';
import { useState } from 'react';
import Chart from 'react-apexcharts';
import { VendasSucessoPorVendedor } from 'types/venda';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

type SeriesData = {
    name: string,
    data: number[]
}
type ChartData = {
    labels: {
        categories: string[]
    },
    series: SeriesData[],
}

const BarChart = () => {

    const [chartData, setCharData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "",
                data: []
            }
        ],
    })

    useEffect(() => {
        axios.get(`${BASE_URL}/vendas/sucesso-por-vendedor`)
            .then(response => {
                const dados = response.data as VendasSucessoPorVendedor[];
                const nomesDosVendedores = dados.map(dado => dado.nomeVendedor);
                const porcentagensVendasSucesso = dados.map(dado => round(100 * dado.totalVendasComSucesso / dado.totalVisitado, 1));
                setCharData({
                    labels: {
                        categories: nomesDosVendedores,
                    },
                    series: [
                        {
                            name: "% Sucesso",
                            data: porcentagensVendasSucesso
                        }
                    ]
                })
            })
    }, [])

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    //const mockData = {
    //    labels: {
    //        categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    //    },
    //    series: [
    //       {
    //            name: "% Sucesso",
    //            data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
    //       }
    //    ]
    //};

    return (
        <>
            <Chart
                options={{ ...options, xaxis: chartData.labels }}
                series={chartData.series}
                type="bar"
                height="240"
            />
        </>
    );
}

export default BarChart;