import './App.css';
import Formulario from './Formulario';
import React, { useState } from 'react';

function App() {

  //Objeto que será enviado para o backend
  const dados = {
    data: "",
    qtdPequenos: 0,
    qtdGrandes: 0
  }

  const [objCanil, setObjCanil] = useState(dados)

  //Obtendo dados do formulário
  const aoDigitar = (e) => {
    const { name, value } = e.target;
    setObjCanil({...objCanil, [name]: value});
}


  //Consumindo a API com os dados do formulário
  const encontrar = () => {
    fetch("http://localhost:8080/petshops/encontrar", {
      method:'post',
      body:JSON.stringify(objCanil),
      headers: {
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    }).then(retorno => retorno.json())
    .then(retorno_convertido => {
      console.log(retorno_convertido);
    })
   
  }

  return (
    <div className="App">
      <p>{JSON.stringify(objCanil)}</p>
      <Formulario eventoTeclado={aoDigitar} consumir={encontrar}/> 
    </div>
  );
}

export default App;
