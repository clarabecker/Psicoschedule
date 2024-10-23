import React from 'react';
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'


import { createBrowserRouter, RouterProvider } from 'react-router-dom'

import MainPage from './Pages/MainPage/MainPage.jsx'
import Login from './Components/Login/Login.jsx'
import Cadastro from './Components/Cadastro/Cadastro.jsx'
import Profiles from './Pages/MainPage/ProfilesMain/Profiles.jsx';
import ClientProfile from './Pages/MainPage/ProfilePage/ClientProfile/ClientProfile.jsx'

const router = createBrowserRouter([
  {
    path: "/",
    element: <MainPage />,
  },
  {
    path: "login",
    element: <Login />,
  },
  {
    path: "cadastro",
    element: <Cadastro />,
  },
  {
    path: "profiles",
    element: <Profiles />,
  },
  {
    path: "clientprofile",
    element: <ClientProfile />,
  },
])
     

createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
