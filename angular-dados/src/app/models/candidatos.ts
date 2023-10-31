export class CandidatosPorEstado {
    candidatosPorEstado: EstatisticaItem[];
    imcMedioPorFaixaEtaria: EstatisticaItem[];
    percentualObesos: EstatisticaItem;
    mediaIdadePorTipoSanguineo: EstatisticaItem[];
    possiveisDoadoresPorTipoSanguineo: EstatisticaItem[];

    constructor(candidatosPorEstado: EstatisticaItem[],
        imcMedioPorFaixaEtaria: EstatisticaItem[],
        percentualObesos: EstatisticaItem,
        mediaIdadePorTipoSanguineo: EstatisticaItem[],
        possiveisDoadoresPorTipoSanguineo: EstatisticaItem[]) {
        this.candidatosPorEstado = candidatosPorEstado;
        this.imcMedioPorFaixaEtaria = imcMedioPorFaixaEtaria;
        this.percentualObesos = percentualObesos;
        this.mediaIdadePorTipoSanguineo = mediaIdadePorTipoSanguineo;
        this.possiveisDoadoresPorTipoSanguineo = possiveisDoadoresPorTipoSanguineo;
    }
}

export class EstatisticaItem {
    constructor(public descricao: string, public valor: number) { }
}