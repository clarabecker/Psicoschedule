import React from "react";
import  Navigation  from "../../../../Components/DrawerNavigation/Navigation";
import HeaderInside from "../../../../Components/HeaderInside/HeaderInside";
import { Card, CardMedia, CardContent, Typography} from "@mui/material";


const ClientProfile= () => {
    return (
        <>
            <HeaderInside />

            <Card sx={{ position: 'relative', width: 400, height: 400, overflow: 'hidden', margin: 20}}> 
         <div className="mainInfos" style={{ position: 'relative' }}>

            <CardMedia
            component="img"
            image="src/assets/Joao.png"
            height="350" 
                
            sx={{
                position: 'absolute', 
                right: 0,          
                top: 0,              
                objectFit: 'contain' 
            }}
            />
        
            <CardContent sx={{ position: 'absolute', top: 335, left: 20, right: 0}}>
            <Typography sx={{fontSize: 30, fontWeight: 500 }}>
                João, 35
            </Typography>
            </CardContent>
        </div>

        </Card>
            

            <div className="navegacao">
                <Navigation /> 
            </div>
           
    </>
    )
   
}

export default ClientProfile;

