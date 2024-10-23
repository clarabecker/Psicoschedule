import React from 'react';
import "./Header.css"; 

import { useNavigate } from "react-router-dom";
import Profiles from '../../Pages/MainPage/ProfilesMain/Profiles';

const Header = () => {

  const navigate = useNavigate();

  const goToLogin = () => {
    navigate('/login');
  };

  const goToCadastro = () => {
    navigate('/cadastro');
  };

  const goToProfissional = () => {
    navigate('/profiles');
  };

 

  return (
    <header>
      <div className="logo"></div>
      <nav className="menu">
        <button id="btnPsicologos" className="vizualizar"> Nossos Psicológos </button>
        <button id="btnProfissionais" className="vizualizar" onClick={goToProfissional}> Colaboradores </button>
        <button id="btnSobre" className="vizualizar"> Sobre nós </button>
      </nav>

      <div className="acessos">
        <button id="btnLogin" className="acesso" onClick={goToLogin}> Login </button>
        <button id="btnCadastro" className="acesso" onClick={goToCadastro}> Cadastra-se </button>
      </div>
    </header>
  );
}

export default Header;
