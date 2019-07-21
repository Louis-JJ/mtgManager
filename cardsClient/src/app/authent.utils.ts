export const hasUser = (): boolean => {
	if(sessionStorage && sessionStorage.getItem('mtgUser')){
		return true;
	} return false;
}
  
export const getUser = () => {
	return JSON.parse(sessionStorage.getItem('mtgUser'));
}