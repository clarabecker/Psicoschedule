import "./HeaderInside.css";
import React from 'react';
import { useNavigate } from "react-router-dom";

const HeaderInside = () => {
    const navigate = useNavigate();

    const goToProfile = () => {
        navigate('/clientprofile');
      };
    return (
        <>
       <header>
            <div className="bio-Image">
                 <img className="profile-image"/>
            </div>

            <nav className="menu">
                 <button id="btnProfissionais" className="vizualizar"> Profissionais </button>
                <button id="btnProfile" className="vizualizar" onClick={goToProfile}> Editar Perfil </button>
                <button id="btnSair" className="vizualizar"> Sair </button>
            </nav>

            <div className="acessos">
                <input type="text" placeholder="Buscar Profissional "/>
                <button id="btnBuscar" className="acesso"> Buscar </button>
                
            </div>
    </header>
      <div className="logo"></div>
      </>



    )
}

export default HeaderInside;

