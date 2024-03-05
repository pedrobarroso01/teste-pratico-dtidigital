function Formulario({eventoTeclado}) {
    return (
        <form>
            <label> Data:
            <input type="date" onChange={eventoTeclado} name="data"/>
            </label>
            <label> Cães pequenos: 
            <input type="number" onChange={eventoTeclado} name="qtdPequenos"/>
            </label>
            <label> Cães grandes: 
            <input type="number" onChange={eventoTeclado} name="qtdGrandes"/>
            </label>
            <button type="submit">Enviar</button>
        </form>
    );
};

export default Formulario;
