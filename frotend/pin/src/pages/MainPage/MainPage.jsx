import { useState } from "react";

import {register} from 'swiper/element/bundle';

register();
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/scrollbar';

import { EffectFade } from 'swiper/modules';
import { Swiper, SwiperSlide } from 'swiper/react';
import 'swiper/css/effect-fade';
import UserComment from '../../Components/User/UserComment';

import Header from "../../Components/Header/Header";
import Footer from "../../Components/Footer/Footer";
import "./MainPage.css";



const MainPage = () => {

 

  const [imagens] = useState([
    { id: '1', image: 'https://saudedigitalnews.com.br/wp-content/uploads/2023/10/PPGP-Psicologia-800x450-Foto-Getty-Images.jpg' },
    { id: '2', image: 'https://prowellness.childrens.pennstatehealth.org/wp-content/uploads/2023/01/four-happy-students-near-university-campus-1024x683.jpg' },
    { id: '3', image: 'https://as1.ftcdn.net/v2/jpg/01/90/00/82/1000_F_190008284_zW3UgTrjLYMLAh64e2rlxPpHyBMDqwTf.jpg' },
    { id: '4', image: 'https://www.discoveryvillages.com/wp-content/uploads/2022/02/happy-senior-friends-dancing.jpg' },
  ]);

  const [comments] = useState([
    {
      id: 1,
      author: 'Alice',
      comment: 'A Dra. mantém altos padrões éticos em todas as suas interações, assegurando a confidencialidade das informações dos clientes e demonstrando um comportamento profissional exemplar. Ela busca continuamente sua atualização profissional, participando de treinamentos e formações relevantes."',
      date: '18/09/2024',
    },
    {
      id: 2,
      author: 'Bob',
      comment: '"A Dra. Manoella estabelece uma conexão genuína com seus clientes, mostrando uma empatia notável e habilidades excepcionais de escuta. Sua abordagem respeitosa e sensível às necessidades individuais cria um ambiente terapêutico de confiança e acolhimento."',
      date: '17/09/2024',
    },
    {
      id: 3,
      author: 'Carlos',
      comment: 'A Dr. se comunica de maneira clara e organizada, garantindo que suas orientações e feedback sejam compreendidos pelos clientes. Sua documentação é detalhada e precisa, refletindo um alto nível de profissionalismo e atenção aos detalhes',
      date: '16/09/2024',
    },
  ]);


return(
<>
     <Header />

     <Swiper 
          effect="fade"
          modules={[EffectFade]}
          pagination={{clickable:true}}
          navigation
        >
              {imagens.map((item)=> (
                  <SwiperSlide key={item.id}>
                    <img 
                    src={item.image} alt="Slider" className="slide-item"
                    />
                  </SwiperSlide>
              ))}
        </Swiper>


      <article>
          <div class="bio-container">
          <img class="bio-image"/>
            <div class="bio-text">
              <h2>Manoella, 32</h2>
              <p>
              Biografia: <br></br>
              Desde pequena, João sempre demonstrou uma curiosidade insaciável e um desejo incessante de aprender. Essas características a levaram a explorar diversas áreas do conhecimento e a se envolver em projetos que visam fazer a diferença na sociedade. Amante dos animais e da natureza, ela dedica parte do seu tempo livre ao voluntariado em abrigos de animais e à participação em iniciativas ambientais.
              </p>
            </div>
        </div>
        
      </article>
      <article>
        <div className="comment-section">
          <h2>Opinião dos usuários: </h2>
          {comments.map((comment) => (
            <UserComment
              key={comment.id}
              author={comment.author}
              comment={comment.comment}
              date={comment.date}
            />
          ))}
        </div>
      </article>

     <Footer />

    </>

)


}

export default MainPage

