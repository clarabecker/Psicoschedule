import React from "react";
import { useNavigate } from 'react-router-dom';
import { Card, CardContent, CardActionArea, CardMedia, Typography, radioClasses, radioGroupClasses} from "@mui/material";

export const CardProfile = ({id}) => {
    const navigate = useNavigate();

    const goToDetailPage = () => {
        navigate(`/profissionalProfile/${id}`);
    };

    return (
        <>
        <Card
             style={{ 
                maxWidth: 300,
                margin: "10%",
                borderRadius: "20px",
            }}
        
        >
          <CardActionArea
            style={{
              transition: "background-color 0.3s ease",
            
            }}
            onMouseEnter={(e) => (e.currentTarget.style.backgroundColor = "#D8BFD8")}
            onMouseLeave={(e) => (e.currentTarget.style.backgroundColor = "white")}
          >

            <CardMedia
              component="img"
              image="src/assets/Joao.png"
              height="200px"
            
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                JOAO, 36
              </Typography>
              <Typography variant="body2" sx={{ color: 'black' }}>
                quantidade estrela
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      </>
      
    )

}