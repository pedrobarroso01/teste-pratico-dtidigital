function Formulario({ eventoTeclado, consumir, resposta }) {
    return (
        <form onSubmit={consumir}>
            <legend> Encontre o melhor Petshop para você! </legend> <br></br>
            <label> Data:
                <input type="date" name="data" onChange={eventoTeclado} required />
            </label>
            <label> Cães pequenos: 
                <input type="number" name="qtdPequenos" onChange={eventoTeclado} min="0" max="100" required />
            </label>
            <label> Cães grandes: 
                <input type="number" name="qtdGrandes" onChange={eventoTeclado} min="0" max="100" required />
            </label>
            <button type="submit">Enviar</button> <br></br>
            <label id = "resposta"> 
                Reposta: 
                <input type ="text" value = {resposta} readOnly></input>
            </label>
        </form>
    );
};

export default Formulario;
