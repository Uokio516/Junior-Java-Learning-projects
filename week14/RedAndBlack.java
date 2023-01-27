public class RedAndBlack {
	private static NodeStruct RBTreeBoot = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//插入節點
		float[] nodeValue = {11, 2, 14, 1, 7, 15, 5, 8, 4, 13};
		for(int i = 0; i < nodeValue.length; i++)
		{
			NodeStruct node = new NodeStruct();
			node.setNodeValue(nodeValue[i]);
			RBTreeBoot = CommonUtil.insertNode(RBTreeBoot, node);
		}
		
		if(RBTreeBoot !=null)
		{
			//深度優先遍歷或者前序遍歷的遞迴展示二叉樹
			RedAndBlack.show(RBTreeBoot);
		}else
		{
			System.out.println("一顆空的紅黑樹！");
		}
		
	}
	
	public static void show(NodeStruct tree)
	{
		if(tree.getLeftNode() != null || tree.getRightNode() !=null)
		{
			if(tree.getLeftNode() != null)
			{
				float x = tree.getLeftNode().getNodeValue();
				boolean color = tree.getLeftNode().getColor();
				String colorStr = null;
				if(color)
				{
					colorStr = "RED";
				}else
				{
					colorStr = "BLACK";
				}
				String parentColor = tree.getColor() ? "RED" : "BLACK";
				System.out.println("left: " + "color: " + colorStr + "-->" + x + "  --父節點-->  " + parentColor + "  " + tree.getNodeValue());
				show(tree.getLeftNode());
			}
			if(tree.getRightNode() != null)
			{
				float y = tree.getRightNode().getNodeValue();
				boolean color = tree.getRightNode().getColor();
				String colorStr = null;
				if(color)
				{
					colorStr = "RED";
				}else
				{
					colorStr = "BLACK";
				}
				String parentColor = tree.getColor() ? "RED" : "BLACK";
				System.out.println("right: " + "color: " + colorStr + "-->" + y + "  --父節點-->  " + parentColor + "  " + tree.getNodeValue());
				show(tree.getRightNode());
			}
		}else
		{
			if(tree.getParentNode() == null)
			{
				System.out.println("該紅黑樹僅有根節點，且  “"+tree.getNodeValue()+ "” 為紅黑樹的根節點");
			}
		}
	}
}