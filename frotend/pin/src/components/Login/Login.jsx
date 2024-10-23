import { FaUser, FaLock } from "react-icons/fa";
import { useState } from "react";
import "./Login.css";

const Login = () => {

    const [username, setUsername] = useState(" ");
    const [password, setPassword] = useState(" ");

    const handleSubmit = (event) => {
        event.preventDefault(); //ele não recarrega a page

        console.log("teste", username, password);
        console.log("Enviou");
    }

    return (
        <>
        <div className="page-container">
            <div className="logo"></div>
            <div className="container"> 
                <h2 id="titulo">Portal do Usuário</h2>
                <form onSubmit={handleSubmit}>
                    <div className="input-field">
                        <input type="email" placeholder="exemplo@email.com" 
                            onChange={(e) => setUsername(e.target.value)} />
                        <FaUser className="icon" />
                    </div>
                    <div className="input-field">
                        <input type="password" placeholder="Informe a senha" 
                            onChange={(e) => setPassword(e.target.value)} />
                        <FaLock className="icon" />
                    </div>

                    <div className="btnLogin">
                        <div className="recall-forget">
                            <label>
                                <input type="checkbox" />
                                Lembre de mim
                            </label>
                        </div>
                        <button type="button">Entrar</button>
                    </div>

                    <div className="signup-link">
                        <p></p>
                    </div>
              </form>
            </div>
</div>

        </>
    )
}

export default Login
