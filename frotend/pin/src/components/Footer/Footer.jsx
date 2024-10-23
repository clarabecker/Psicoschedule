import "./Footer.css";
import React from 'react';

const Footer = () => {
    return (
    <footer>
        <nav className="menufooter">
            <button id="btnPsicologos" className="vizualizar"> Nossos Psicológos </button>
            <button id="btnProfissionais" className="vizualizar"> Colaboradores </button>
            <button id="btnSobre" className="vizualizar"> Sobre nós </button>
        </nav>
        <div className="infos">
            <div className="logo"></div>
            <p>Psicológo responsável: Dr. Fulano Souza (CRM: 1234567890)</p>
            <p>Plataforma desenvolvida por: Clara dos Santos Becker, Lucas Gabriel Falcade Nunes e Luiz Albert</p>
        </div>
    </footer>
    );
}

export default Footer
