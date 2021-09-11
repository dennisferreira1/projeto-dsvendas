import axios from 'axios';
import { useEffect } from 'react';
import { useState } from 'react';
import Chart from 'react-apexcharts';
import { TotalVendasPorVendedor } from 'types/venda';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    series: number[],
    labels: string[]
}
const DonutChart = () => {

    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });
    useEffect(() => {
        axios.get(`${BASE_URL}/soma-valor-por-vendedor`)
            .then(response => {
                const dados = response.data as TotalVendasPorVendedor[];
                const nomesDosVendedores = dados.map(dado => dado.nomeVendedor);
                const valoresTotaisDasVendas = dados.map(dado => dado.somaValorTotal);
                setChartData({ labels: nomesDosVendedores, series: valoresTotaisDasVendas })
            })

    }, []);

    //const mockData = {
    //    series: [477138, 499928, 444867, 220426, 473088],
    //    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    //}

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <>
            <Chart
                options={{ ...options, labels: chartData.labels }}
                series={chartData.series}
                type="donut"
                height="240"
            />
        </>
    );
}

export default DonutChart;