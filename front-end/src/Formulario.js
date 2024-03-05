function Formulario({ eventoTeclado, consumir }) {
    return (
        <form onSubmit={consumir}>
            <label> Data:
                <input type="date" name="data" onChange={eventoTeclado} />
            </label>
            <label> Cães pequenos: 
                <input type="number" name="qtdPequenos" onChange={eventoTeclado} />
            </label>
            <label> Cães grandes: 
                <input type="number" name="qtdGrandes" onChange={eventoTeclado} />
            </label>
            <button type="submit">Enviar</button>
        </form>
    );
};

export default Formulario;
