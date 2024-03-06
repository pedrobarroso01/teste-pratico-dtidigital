import './App.css';
import Formulario from './Formulario';
import React, { useState } from 'react';
import pessoa from './pessoa.jpg';
import dog from './dog.png';


function App() {

  //Objeto que será enviado para o backend
  const dados = {
    data: "",
    qtdPequenos: 0,
    qtdGrandes: 0
  }

  const [objCanil, setObjCanil] = useState(dados);
  const [retornoAPI, setRetornoAPI] = useState("");

  //Obtendo dados do formulário
  const aoDigitar = (e) => {
    const { name, value } = e.target;
    setObjCanil({...objCanil, [name]: value});
}


  //Consumindo a API com os dados do formulário
  const encontrar = (e) => {
    e.preventDefault(); 
    fetch("http://localhost:8080/petshops/encontrar", {
      method:'post',
      body:JSON.stringify(objCanil),
      headers: {
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno => {
      if (!retorno.ok) {
        throw new Error('Erro ao receber a resposta da API');
      }
      return retorno.text();
    })
    .then(retorno_texto => {
      console.log("Resposta da API:", retorno_texto);
      setRetornoAPI(retorno_texto)
    })
    .catch(error => {
      console.error("Erro ao fazer a solicitação:", error);
    });
  }

  return (
    <div className="App">
      <div class = "header">
        <img src={pessoa}></img>
        <h1> Cães do Lar Canil</h1>
      </div>
      <div class = "content">
      <Formulario eventoTeclado={aoDigitar} consumir={encontrar} resposta={retornoAPI}/> 
      <img src={dog}></img>
      </div>
    </div>
  );
}

export default App;
