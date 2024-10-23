// src/ProfilesList.js
import React from 'react';
import Profile from './Profile';



const Profiles = () => {
    const profiles = [
        {
          name: "Manoella",
          age: 25,
          bio: "Desde pequena, Manoella sempre demonstrou uma curiosidade insaciável e um desejo incessante de aprender. Essas características a levaram a explorar diversas áreas do conhecimento e a se envolver em projetos que visam fazer a diferença na sociedade. Amante dos animais e da natureza, ela dedica parte do seu tempo livre ao voluntariado em abrigos de animais e à participação em iniciativas ambientais.",
          image: "assets/Manoella.png"
        },
        {
          name: "João",
          age: 32,
          bio: "Desde pequena, João sempre demonstrou uma curiosidade insaciável e um desejo incessante de aprender. Essas características o levaram a explorar diversas áreas do conhecimento e a se envolver em projetos que visam fazer a diferença na sociedade. Amante dos animais e da natureza, ele dedica parte do seu tempo livre ao voluntariado em abrigos de animais e à participação em iniciativas ambientais.",
          image: "assets/Joao.png"
        }
      ];

  return (
    <div>
      {profiles.map(profile => (
        <Profile
          key={profile.name}
          name={profile.name}
          age={profile.age}
          bio={profile.bio}
          image={profile.image}
        />
      ))}
    </div>
  );
};

export default Profiles;
