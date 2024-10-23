import { useState } from "react";
import "./Cadastro.css";

const Cadastro = () => {

    const [username, setUsername] = useState(" ");
    const [password, setPassword] = useState(" ");
    const [gender, setGender] = useState("");
    const [addres, setAddress] = useState("");
    const [data, setData] = useState("");
    const [cpf, setCpf] = useState("");

    const handleImageChange = (e) => {
        const file = e.target.files[0];
        if (file) {
          setImage(file);
          setImagePreview(URL.createObjectURL(file));
        }
      };

    const handleSubmit = (event) => {
        event.preventDefault(); //ele não recarrega a page

        if (!username || !email || !gender || !address) {
            console.log("Por favor, preencha todos os campos.");
            return;
          }

            console.log("Dados do formulário:");
            console.log("Nome:", username);
            console.log("E-mail:", email);
            console.log("Gênero:", gender);
            console.log("Endereço:", address);
            console.log("Senha: ", password);
            console.log("Enviou");
    }

    return(
        <div className="page-container">
            <div className="logo"></div>
            <div className="container">
            <h2>Cadastro do Paciente</h2>
                <form onSubmit={handleSubmit}>
                    <div className="input-field">
                        <p>Nome:</p>
                        <input type="name" placeholder="Nome Completo" 
                            onChange={(e) => setUsername(e.target.value)}/>
                    </div>
                    <div className="input-field">
                        <p>e-Mail:</p>
                        <input type="email" placeholder="exemplo@email.com" 
                            onChange={(e) => setEmail(e.target.value)}/>
                    </div>
                    <div className="input-field">
                        <p>Gênero:</p>
                        <input type="text" placeholder="Fem/Mas/Prefiro não informar" 
                            onChange={(e) => setGender(e.target.value)}/>
                    </div>
                    <div className="input-field">
                        <p>Cidade</p>
                        <input type="text" placeholder="Cidade " 
                            onChange={(e) => setAddress(e.target.value)}/>
                    </div>
                    <div className="input-field">
                        <p>Senha:</p>
                        <input type="password" placeholder="Senha: " 
                            onChange={(e) => setPassword(e.target.value)}/>
                    </div>
                </form>

                <div className="btnCadastro">
                    <button type="button">Entrar</button>

                    </div>

                    
            </div>
        </div>

    )   

}
export default Cadastro