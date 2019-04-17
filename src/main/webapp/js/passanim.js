function passanim()
{
    var x = document.getElementById("paslog")
    if(x.type === "password")
    {
        x.type = "text";

    }
    else
    {
    x.type = "password";
    }
}